package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.chatMessages;
import za.ac.cput.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatMessagesController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/messages")
    public ResponseEntity<chatMessages> saveMessage(@RequestBody chatMessages chatMessage) {
        chatMessages savedMessage = chatService.saveMessage(chatMessage);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping("/messages/session/{sessionId}")
    public ResponseEntity<List<chatMessages>> getMessagesBySessionId(@PathVariable("sessionId") int sessionId) {
        List<chatMessages> messages = chatService.getMessagesBySessionId(sessionId);
        if (messages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
        //This is new code
        //Testing
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessageById(@PathVariable("id") Long id) {
        chatService.deleteMessageById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
