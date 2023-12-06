package cz.ds.log.analyzer;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MdcData(
        @JsonProperty("event.action") String eventAction,
        @JsonProperty("event.id") String eventId,
        @JsonProperty("event.owner") String eventOwner,
        @JsonProperty("event.pr") String eventPr,
        @JsonProperty("event.repo") String eventRepo,
        @JsonProperty("event.type") String eventType,
        @JsonProperty("git.branch") String gitBranch,
        @JsonProperty("git.rev") String gitRev,
        @JsonProperty("git.url") String gitUrl,
        @JsonProperty("reconcile.change") String reconcileChange,
        @JsonProperty("reconcile.env") String reconcileEnv,
        @JsonProperty("reconcile.org") String reconcileOrg,
        @JsonProperty("reconcile.pr") String reconcilePr,
        @JsonProperty("reconcile.repo") String reconcileRepo,
        @JsonProperty("reconcile.sas") String reconcileSas,
        @JsonProperty("github.repo") String githubRepo,
        @JsonProperty("snow.change") String snowChange
) {
}
