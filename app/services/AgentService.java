package services;

import com.fasterxml.jackson.databind.JsonNode;
import data.AgentResponce;
import play.libs.ws.WS;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

public class AgentService {
    public AgentResponce getAgentResponse(String text) {
        AgentResponce agentResponce = new AgentResponce();
        try {
            WSRequest queryRequest = WS.url("https://api.api.ai/api/query");
            CompletionStage<WSResponse> responsePromise = queryRequest
                    .setQueryParameter("v", "20150910")
                    .setQueryParameter("query",text)
                    .setQueryParameter("lang", "en")
                    .setQueryParameter("sessionId", UUID.randomUUID().toString())
                    .setQueryParameter("timezone", "2017-08-09T03:25:23+0530")
                    .setHeader("Authorization", "Bearer 946df4ead6524dbcaeb5c6c2409462b6")
                    .get();
            JsonNode response = responsePromise.thenApply(WSResponse::asJson).toCompletableFuture().get();
            agentResponce.keyword = response.get("result").get("parameters").get("keyword").asText();


        } catch (Exception e) {
           e.printStackTrace();
        }
        return agentResponce;
    }

}
