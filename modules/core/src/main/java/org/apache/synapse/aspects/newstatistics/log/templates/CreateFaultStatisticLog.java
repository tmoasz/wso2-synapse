/*
 *   Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.aspects.newstatistics.log.templates;

import org.apache.synapse.MessageContext;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.aspects.ComponentType;
import org.apache.synapse.aspects.newstatistics.RuntimeStatisticCollector;
import org.apache.synapse.aspects.newstatistics.StatisticDataUnit;

public class CreateFaultStatisticLog implements StatisticReportingLog {

	StatisticDataUnit statisticDataUnit;

	public CreateFaultStatisticLog(MessageContext messageContext, String componentId, ComponentType componentType,
	                               String parentId, Long startTime) {
		String statisticId = (String) messageContext.getProperty(SynapseConstants.NEW_STATISTICS_ID);
		int cloneId;
		if (messageContext.getProperty(SynapseConstants.NEW_STATISTICS_MESSAGE_ID) != null) {
			cloneId = (Integer) messageContext.getProperty(SynapseConstants.NEW_STATISTICS_MESSAGE_ID);
		} else {
			cloneId = 0;
		}
		statisticDataUnit = new StatisticDataUnit(statisticId, componentId, componentType, parentId, cloneId, startTime,
		                                          messageContext.isResponse());
	}

	@Override public void process() {
		RuntimeStatisticCollector
				.recordStatisticCreateFaultLog(statisticDataUnit);
	}
}
