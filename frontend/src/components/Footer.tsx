import React from 'react';
import {Link} from 'react-router-dom';
import {FaLinkedin, FaGithub} from 'react-icons/fa';
import {useTranslation} from "react-i18next";

export const Footer: React.FC = () => {
    const {t} = useTranslation();

    return(
        <footer className="footer">
            <div className="footer-links">
                <Link to="/" className="footer-link">{t('footer.home')}</Link>
                <Link to="/profile" className="footer-link">{t('footer.profile')}</Link>
            </div>

            <div className="social-icons">
                <a href="https://www.linkedin.com/in/oleksandr-biktimirov-5b4b6926b/" target="_blank" rel="noopener noreferrer" className="footer-link">
                    <FaLinkedin />
                </a>
                <a href="https://github.com/alexandrbiktimirov" target="_blank" rel="noopener noreferrer" className="footer-link">
                    <FaGithub />
                </a>
            </div>

            <p className="text-sm">
                &copy; {new Date().getFullYear()} Alexandr Biktimirov. {t('footer.rights')}.
            </p>
        </footer>
    );
};