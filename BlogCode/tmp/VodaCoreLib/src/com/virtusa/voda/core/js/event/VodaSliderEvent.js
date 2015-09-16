///**
// * Fires a select type event to the server for the source component
// * when a tag is clicked.
// */
//function VodaTagSelectEvent(source, tag) {
//    AdfAssert.assertPrototype(source, AdfUIComponent);
//    AdfAssert.assertString(tag);
//    this.Init(source, tag);
//}
//// make VodaTagSelectEvent a subclass of AdfComponentEvent
//AdfObject.createSubclass(VodaTagSelectEvent, AdfComponentEvent);
///**
// * The event type
// */
//VodaTagSelectEvent.SELECT_EVENT_TYPE = "tagSelect";
///**
// * Event Object constructor
// */
//VodaTagSelectEvent.prototype.Init = function (source, tag) {
//    AdfAssert.assertPrototype(source, AdfUIComponent);
//    AdfAssert.assertString(tag);
//    this._tag = tag;
//    VodaTagSelectEvent.superclass.Init.call(this, source, VodaTagSelectEvent.SELECT_EVENT_TYPE);
//}
///**
// * Indicates this event should be sent to the server
// */
//VodaTagSelectEvent.prototype.propagatesToServer = function () {
//    return true;
//}
///**
// * Override of AddMarshalledProperties to add parameters * sent server side.
// */
//VodaTagSelectEvent.prototype.AddMarshalledProperties = function (properties) {
//    properties.tag = this._tag;
//
//}
///**
// * Convenient method for queue a VodaTagSelectEvent.
// */
//VodaTagSelectEvent.queue = function (component, tag) {
//    AdfAssert.assertPrototype(component, AdfUIComponent);
//    AdfAssert.assertString(tag);
//    // AdfLogger.LOGGER.logMessage(AdfLogger.FINEST,     "VodaTagSelectEvent.queue(component, tag)");
//new VodaTagSelectEvent(component, tag).queue(true);
//}
///**
// * returns the selected file type
// */
//VodaTagSelectEvent.prototype.getTag = function () {
//    return this._tag;
//}
///**
// * returns a debug string
// */
//VodaTagSelectEvent.prototype.toDebugString = function () {
//    var superString = VodaTagSelectEvent.superclass.toDebugString.call(this);
//    return superString.substring(0, superString.length - 1) + ", tag=" + this._tag + "]";
//}
/*
*
* Make sure that this event only invokes immediate validators 
* on the client. 
*/
/*
 VodaTagSelectEvent.prototype.isImmediate = function () {
    return true;
}*/