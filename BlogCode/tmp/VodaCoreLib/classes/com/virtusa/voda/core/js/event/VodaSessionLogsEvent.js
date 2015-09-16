/**
 * Fires a select type event to the server for the source component
 * when a tag is clicked.
 */
function VodaSessionLogsTimeFrameSelectEvent(source, timeFrame) {
    AdfAssert.assertPrototype(source, AdfUIComponent);
    AdfAssert.assertString(timeFrame);
    this.Init(source, timeFrame);
}
function VodaSessionLogsDataFilterSelectEvent(source, dataFilter) {
    AdfAssert.assertPrototype(source, AdfUIComponent);
    AdfAssert.assertString(dataFilter);
    this.Init(source, dataFilter);
}
function VodaSessionLogsTimeScaleSelectEvent(source, timeScale) {
    AdfAssert.assertPrototype(source, AdfUIComponent);
    AdfAssert.assertString(timeScale);
    this.Init(source, timeScale);
}
// make VodaSessionLogsEvent a subclass of AdfComponentEvent
AdfObject.createSubclass(VodaSessionLogsTimeFrameSelectEvent, AdfComponentEvent);
AdfObject.createSubclass(VodaSessionLogsDataFilterSelectEvent, AdfComponentEvent);
AdfObject.createSubclass(VodaSessionLogsTimeScaleSelectEvent, AdfComponentEvent);
/**
 * The event type
 */
VodaSessionLogsTimeFrameSelectEvent.TIME_FRAME_SELECT_EVENT_TYPE = "TimeFrameSelectEvent";
VodaSessionLogsDataFilterSelectEvent.DATA_FILTER_SELECT_EVENT_TYPE = "DataFilterSelectEvent";
VodaSessionLogsTimeScaleSelectEvent.TIME_SCALE_SELECT_EVENT_TYPE = "TimeScaleSelectEvent";
/**
 * Event Object constructor
 */
VodaSessionLogsTimeFrameSelectEvent.prototype.Init = function (source, timeFrame) {
    AdfAssert.assertPrototype(source, AdfUIComponent);
    AdfAssert.assertString(timeFrame);
    this._timeFrame = timeFrame;
    VodaSessionLogsTimeFrameSelectEvent.superclass.Init.call(this, source, VodaSessionLogsTimeFrameSelectEvent.TIME_FRAME_SELECT_EVENT_TYPE);
}
VodaSessionLogsDataFilterSelectEvent.prototype.Init = function (source, dataFilter) {
    AdfAssert.assertPrototype(source, AdfUIComponent);
    AdfAssert.assertString(dataFilter);
    this._dataFilter = dataFilter;
    VodaSessionLogsDataFilterSelectEvent.superclass.Init.call(this, source, VodaSessionLogsDataFilterSelectEvent.DATA_FILTER_SELECT_EVENT_TYPE);
}
VodaSessionLogsTimeScaleSelectEvent.prototype.Init = function (source, timeScale) {
    AdfAssert.assertPrototype(source, AdfUIComponent);
    AdfAssert.assertString(timeScale);
    this._timeScale = timeScale;
    VodaSessionLogsTimeScaleSelectEvent.superclass.Init.call(this, source, VodaSessionLogsTimeScaleSelectEvent.TIME_SCALE_SELECT_EVENT_TYPE);
}
/**
 * Indicates this event should be sent to the server
 */
VodaSessionLogsTimeFrameSelectEvent.prototype.propagatesToServer = function () {
    return true;
}
VodaSessionLogsDataFilterSelectEvent.prototype.propagatesToServer = function () {
    return true;
}
VodaSessionLogsTimeScaleSelectEvent.prototype.propagatesToServer = function () {
    return true;
}
/**
 * Override of AddMarshalledProperties to add parameters * sent server side.
 */
VodaSessionLogsTimeFrameSelectEvent.prototype.AddMarshalledProperties = function (properties) {
    properties._timeFrame = this._timeFrame;
}
VodaSessionLogsDataFilterSelectEvent.prototype.AddMarshalledProperties = function (properties) {
    properties._dataFilter = this._dataFilter;
}
VodaSessionLogsTimeScaleSelectEvent.prototype.AddMarshalledProperties = function (properties) {
    properties._timeScale = this._timeScale;
}
/**
 * Convenient method for queue a VodaSessionLogsEvent.
 */
VodaSessionLogsTimeFrameSelectEvent.queue = function (component, timeFrame) {
    AdfAssert.assertPrototype(component, AdfUIComponent);
    AdfAssert.assertString(timeFrame);
    new VodaSessionLogsTimeFrameSelectEvent(component, timeFrame).queue(true);
}
VodaSessionLogsDataFilterSelectEvent.queue = function (component, dataFilter) {
    AdfAssert.assertPrototype(component, AdfUIComponent);
    AdfAssert.assertString(dataFilter);
    new VodaSessionLogsDataFilterSelectEvent(component, dataFilter).queue(true);
}
VodaSessionLogsTimeScaleSelectEvent.queue = function (component, timeScale) {
    AdfAssert.assertPrototype(component, AdfUIComponent);
    AdfAssert.assertString(timeScale);
    new VodaSessionLogsTimeScaleSelectEvent(component, timeScale).queue(true);
}
/**
 * returns the selected file type
 */
VodaSessionLogsTimeFrameSelectEvent.prototype.getTimeFrame = function () {
    return this._timeFrame;
}
VodaSessionLogsDataFilterSelectEvent.prototype.getDataFilter = function () {
    return this._dataFilter;
}
VodaSessionLogsTimeScaleSelectEvent.prototype.getTimeScale = function () {
    return this._timeScale;
}
/**
 * returns a debug string
 */
VodaSessionLogsTimeFrameSelectEvent.prototype.toDebugString = function () {
    var superString = VodaSessionLogsTimeFrameSelectEvent.superclass.toDebugString.call(this);
    return superString.substring(0, superString.length - 1) + ", timeFrame=" + this._timeFrame + "]";
}
VodaSessionLogsDataFilterSelectEvent.prototype.toDebugString = function () {
    var superString = VodaSessionLogsDataFilterSelectEvent.superclass.toDebugString.call(this);
    return superString.substring(0, superString.length - 1) + ", dataFilter=" + this._dataFilter + "]";
}
VodaSessionLogsTimeScaleSelectEvent.prototype.toDebugString = function () {
    var superString = VodaSessionLogsTimeScaleSelectEvent.superclass.toDebugString.call(this);
    return superString.substring(0, superString.length - 1) + ", timeScale=" + this._timeScale + "]";
}
/*
*
* Make sure that this event only invokes immediate validators 
* on the client. 
*/

 VodaSessionLogsTimeFrameSelectEvent.prototype.isImmediate = function () {
    return true;
}
VodaSessionLogsDataFilterSelectEvent.prototype.isImmediate = function () {
    return true;
}
VodaSessionLogsTimeScaleSelectEvent.prototype.isImmediate = function () {
    return true;
}
 /**/