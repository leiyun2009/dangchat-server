package im.actor.server.bot.services

import akka.actor.ActorSystem
import im.actor.bots.BotMessages
import im.actor.server.bot.{ BotExtension, BotServiceBase }
import im.actor.server.user.UserErrors
import upickle.Js

private[bot] final class BotsBotService(system: ActorSystem) extends BotServiceBase(system) {
  import BotMessages._
  import system.dispatcher

  val botExt = BotExtension(system)
  val db = im.actor.server.db.DbExtension(system).db

  private def createBot(nickname: String, name: String) = RequestHandler[CreateBot, CreateBot#Response](
    (botUserId: BotUserId, botAuthId: BotAuthId, botAuthSid: BotAuthSid) ⇒
      ifIsAdmin(botUserId) {
        (for {
          (token, userId) ← botExt.create(nickname, name, isAdmin = false)

          //新创建的bot保存到user_bots表中
          //by Lining 2016/8/29
          _ ← db.run(im.actor.server.persist.UserBotRepo.create(userId, nickname, name, token))
        } yield Right(BotCreated(token, userId))) recover {
          case UserErrors.NicknameTaken ⇒
            Left(BotError(400, "USERNAME_TAKEN", Js.Obj(), None))
        }
      }
  )

  override def handlers: PartialFunction[RequestBody, WeakRequestHandler] = {
    case CreateBot(nickname, name) ⇒ createBot(nickname, name).toWeak
  }
}
