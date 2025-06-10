package com.adobe.aem.may.batch.core.workflows;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;


@Component(service = WorkflowProcess.class,
        property = {"process.label=Practice Custom Workflow Process" })
public class PracticeWorkflow implements WorkflowProcess{

    private static final Logger LOG = LoggerFactory.getLogger(PracticeWorkflow.class);

    @Override
    public void execute(WorkItem workitem, WorkflowSession wfSession, MetaDataMap metaDataMap) throws WorkflowException {
        
           String  payloadType = workitem.getWorkflowData().getPayloadType();

            if (StringUtils.equals(payloadType, "JCR_PATH")) {
                LOG.info("Payload type: {}", payloadType);

                String path = workitem.getWorkflowData().getPayload().toString();
                LOG.info("Payload path: {}", path);
            }

            String args = metaDataMap.get("PROCESS_ARGS", String.class);
            LOG.info("Process args: {}", args);
    }

    }

    

    


