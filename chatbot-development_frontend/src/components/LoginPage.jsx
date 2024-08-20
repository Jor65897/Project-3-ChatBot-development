import React from 'react';
//import './LoginPage.css';

const LoginPage = () => {
    return (
        <div className="login-container">
            <h1>Login</h1>
            <form className="login-form">
                <div className="input-container">
                    <input type="text" placeholder="Username..." />
                </div>
                <div className="input-container">
                    <input type="password" placeholder="Password..." />
                </div>
                <button type="submit" className="login-button">Login</button>
            </form>
            <a href="#" className="register-link">Register...</a>
        </div>
    );
}

export default LoginPage;
