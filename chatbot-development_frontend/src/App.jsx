// App.js
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import Chat from './Components/Chat';
import Login from './Components/LoginPage';
import './App.css';

function App() {
    return (
        <Router>
            <div style={{ padding: '20px' }}>
                <nav>
                    <Link to="/chat">Chat</Link> | <Link to="/login">Login</Link>
                </nav>
                <Routes>
                    {/* Routes component should wrap around all Route components */}
                    <Route path="/login" element={<Login />} />
                    <Route path="/chat" element={<Chat />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
