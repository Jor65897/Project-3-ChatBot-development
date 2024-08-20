import React, { useState, useEffect } from 'react';
//import './Chat.css';
// import { saveMessage, getMessagesBySessionId } from './chatService';

function Chat() {
    const [messages, setMessages] = useState([]);
    const [input, setInput] = useState('');
    const sessionId = 1; // Example session ID; this could be dynamic

    // useEffect(() => {
    //     // Fetch messages when the component mounts
    //     const fetchMessages = async () => {
    //         try {
    //             const data = await getMessagesBySessionId(sessionId);
    //             setMessages(data);
    //         } catch (error) {
    //             console.error('Error fetching messages:', error);
    //         }
    //     };

    //     fetchMessages();
    // }, [sessionId]);

    const handleSendMessage = async () => {
        if (input.trim() !== '') {
            const message = { sender: 'You', text: input, sessionId: sessionId };

            // try {
            //     // Save the message to the backend
            //     const savedMessage = await saveMessage(message);
            //     // Update the message list
            //     setMessages([...messages, savedMessage]);
            //     setInput('');
            // } catch (error) {
            //     console.error('Error sending message:', error);
            // }

            // Temporarily display the message without backend integration
            setMessages([...messages, message]);
            setInput('');
        }
    };

    return (
        <div className="chat-wrapper">
            <header>
                <nav>
                    <button>Previous Chats</button>
                    <button>Logout</button>
                </nav>
            </header>
            <div className="chat-output">
                {messages.map((msg, index) => (
                    <div key={index} className={`chat-message ${msg.sender.toLowerCase()}`}>
                        <strong>{msg.sender}:</strong> {msg.text}
                    </div>
                ))}
            </div>
            <div className="chat-input">
                <input
                    type="text"
                    value={input}
                    placeholder="Message our ChatBot..."
                    onChange={(e) => setInput(e.target.value)}
                    onKeyDown={(e) => e.key === 'Enter' && handleSendMessage()}
                />
                <button onClick={handleSendMessage}>Send</button>
            </div>
        </div>
    );
}

export default Chat;