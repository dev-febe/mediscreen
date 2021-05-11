package com.mediscreen.msreport.proxy;

import com.mediscreen.msreport.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-note", url = "${proxy.ms.note.url}")
public interface MsNoteProxy {
    @GetMapping("/patHistory/list")
    List<Note> getNotes(@RequestParam Long patientId);
}
