package com.taikang.dic.ltci.portal.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taikang.dic.ltci.portal.api.model.AttachmentDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.media.file.client}", url = "${feign.media.file.url}")
public interface AttachmentServiceClient {

  @RequestMapping(value = "/api/v1/attachment", method = RequestMethod.POST)
  public ResultDTO addAttachment(@RequestBody AttachmentDTO dto);

  @RequestMapping(value = "/api/v1/attachment/{id}/{fileType}", method = RequestMethod.DELETE)
  public ResultDTO deleteAttachment(
      @PathVariable(value = "id") String id, @PathVariable(value = "fileType") String fileType);

  @RequestMapping(value = "/api/v1/attachment/{id}/{fileType}", method = RequestMethod.GET)
  public ResultDTO getAttachmentByID(
      @PathVariable(value = "id") String id, @PathVariable(value = "fileType") String fileType);
}
