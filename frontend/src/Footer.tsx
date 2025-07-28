import React from "react";
import {Link} from "react-router-dom";
import {FaLinkedin, FaGithub} from 'react-icons/fa';


export const Footer: React.FC = () => {

    return(
        <footer className="bg-gray-800 text-gray-200 py-6 text-center mt-5">
            <div className="space-x-6 mb-4">
                <Link to="/">Home</Link>
                <Link to="/forum">Forum</Link>
                <Link to="/profile">Profile</Link>
            </div>

            <div className="flex justify-center space-x-4 mb-4 text-xl">
                <a href="https://www.linkedin.com/in/oleksandr-biktimirov-5b4b6926b/" target="_blank" rel="noopener noreferrer"><FaLinkedin/></a>
                <a href="https://github.com/alexandrbiktimirov" target="_blank" rel="noopener noreferrer"><FaGithub/></a>
            </div>

            <p className="text-sm">
                &copy; {new Date().getFullYear()} Alexandr Biktimirov. All rights reserved.
            </p>
        </footer>
    );
}