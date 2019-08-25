package org.apache.synapse.aspects.flow.statistics.tracing.manager;

import io.opentracing.Span;
import org.apache.synapse.MessageContext;
import org.apache.synapse.aspects.flow.statistics.data.raw.BasicStatisticDataUnit;
import org.apache.synapse.aspects.flow.statistics.data.raw.StatisticDataUnit;
import org.apache.synapse.aspects.flow.statistics.tracing.manager.subhandlers.SubHandler;

public interface OpenTracingManager {
    void initializeTracer();

    void resolveHandler();

    void addSubHandler(Object referrer, SubHandler subHandler);

    void removeSubHandler(Object referrer);

    void handleOpenEvent(StatisticDataUnit statisticDataUnit, MessageContext synCtx, Span parentSpan);

    void handleOpenEntryEvent(String absoluteId, StatisticDataUnit statisticDataUnit, MessageContext synCtx);

    void handleOpenChildEntryEvent(String absoluteId, StatisticDataUnit statisticDataUnit, MessageContext synCtx);

    void handleOpenFlowContinuableEvent(String absoluteId, StatisticDataUnit statisticDataUnit, MessageContext synCtx);

    void handleOpenFlowSplittingEvent(String absoluteId, StatisticDataUnit statisticDataUnit, MessageContext synCtx);

    void handleOpenFlowAggregateEvent(String absoluteId, StatisticDataUnit statisticDataUnit, MessageContext synCtx);

    void handleOpenFlowAsynchronousEvent(String absoluteId, BasicStatisticDataUnit statisticDataUnit, MessageContext synCtx);

    void handleOpenContinuationEvents(String absoluteId, BasicStatisticDataUnit statisticDataUnit, MessageContext synCtx);



    void handleCloseEvent(BasicStatisticDataUnit basicStatisticDataUnit, MessageContext synCtx);

    void handleCloseEntryEvent(BasicStatisticDataUnit basicStatisticDataUnit, MessageContext synCtx);

    void handleCloseFlowForcefully(BasicStatisticDataUnit basicStatisticDataUnit, MessageContext synCtx);

    void handleTryEndFlow(BasicStatisticDataUnit basicStatisticDataUnit, MessageContext synCtx);



    void handleAddCallback(MessageContext messageContext, String callbackId);

    void handleCallbackCompletionEvent(MessageContext oldMssageContext, String callbackId);

    void handleUpdateParentsForCallback(MessageContext oldMessageContext, String callbackId);

    void handleReportCallbackHandlingCompletion(MessageContext synapseOutMsgCtx, String callbackId);


    void handleStackInsertion(MessageContext synCtx);

    void handleStackRemoval(MessageContext synCtx);

    void handleStackClearance(MessageContext synCtx);

    void closeTracer();
}
