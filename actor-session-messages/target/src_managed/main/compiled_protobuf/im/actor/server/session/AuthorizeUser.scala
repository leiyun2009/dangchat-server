// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO2

package im.actor.server.session


import im.actor.server.api.TypeMappers._
import scala.collection.JavaConversions._

@SerialVersionUID(0L)
final case class AuthorizeUser(
    userId: Int = 0,
    authSid: Int = 0,
    appId: Int = 0
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[AuthorizeUser] with com.trueaccord.lenses.Updatable[AuthorizeUser] with im.actor.server.session.SessionMessage {
    @transient
    lazy val serializedSize: Int = {
      var __size = 0
      __size += com.google.protobuf.CodedOutputStream.computeInt32Size(1, userId)
      __size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, authSid)
      __size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, appId)
      __size
    }
    def writeTo(output: com.google.protobuf.CodedOutputStream): Unit = {
      output.writeInt32(1, userId)
      output.writeInt32(2, authSid)
      output.writeInt32(3, appId)
    }
    def mergeFrom(__input: com.google.protobuf.CodedInputStream): im.actor.server.session.AuthorizeUser = {
      var __userId = this.userId
      var __authSid = this.authSid
      var __appId = this.appId
      var _done__ = false
      while (!_done__) {
        val _tag__ = __input.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 8 =>
            __userId = __input.readInt32()
          case 16 =>
            __authSid = __input.readInt32()
          case 24 =>
            __appId = __input.readInt32()
          case tag => __input.skipField(tag)
        }
      }
      im.actor.server.session.AuthorizeUser(
          userId = __userId,
          authSid = __authSid,
          appId = __appId
      )
    }
    def withUserId(__v: Int): AuthorizeUser = copy(userId = __v)
    def withAuthSid(__v: Int): AuthorizeUser = copy(authSid = __v)
    def withAppId(__v: Int): AuthorizeUser = copy(appId = __v)
    def getField(__field: com.google.protobuf.Descriptors.FieldDescriptor): scala.Any = {
      __field.getNumber match {
        case 1 => userId
        case 2 => authSid
        case 3 => appId
      }
    }
    override def toString: String = com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = im.actor.server.session.AuthorizeUser
}

object AuthorizeUser extends com.trueaccord.scalapb.GeneratedMessageCompanion[AuthorizeUser]  {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[AuthorizeUser]  = this
  def fromFieldsMap(__fieldsMap: Map[com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): im.actor.server.session.AuthorizeUser = {
    require(__fieldsMap.keys.forall(_.getContainingType() == descriptor), "FieldDescriptor does not match message type.")
    val __fields = descriptor.getFields
    im.actor.server.session.AuthorizeUser(
      __fieldsMap(__fields.get(0)).asInstanceOf[Int],
      __fieldsMap(__fields.get(1)).asInstanceOf[Int],
      __fieldsMap(__fields.get(2)).asInstanceOf[Int]
    )
  }
  def descriptor: com.google.protobuf.Descriptors.Descriptor = SessionProto.descriptor.getMessageTypes.get(2)
  def messageCompanionForField(__field: com.google.protobuf.Descriptors.FieldDescriptor): com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__field)
  def enumCompanionForField(__field: com.google.protobuf.Descriptors.FieldDescriptor): com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__field)
  lazy val defaultInstance = im.actor.server.session.AuthorizeUser(
    userId = 0,
    authSid = 0,
    appId = 0
  )
  implicit class AuthorizeUserLens[UpperPB](_l: com.trueaccord.lenses.Lens[UpperPB, AuthorizeUser]) extends com.trueaccord.lenses.ObjectLens[UpperPB, AuthorizeUser](_l) {
    def userId: com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.userId)((c_, f_) => c_.copy(userId = f_))
    def authSid: com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.authSid)((c_, f_) => c_.copy(authSid = f_))
    def appId: com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.appId)((c_, f_) => c_.copy(appId = f_))
  }
  final val USER_ID_FIELD_NUMBER = 1
  final val AUTH_SID_FIELD_NUMBER = 2
  final val APP_ID_FIELD_NUMBER = 3
}