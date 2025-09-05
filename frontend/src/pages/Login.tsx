import React from "react";
import {useTranslation} from "react-i18next";
import {Link} from "react-router-dom";

export const Login : React.FC = () => {
    const {t} = useTranslation();

    return (
        <div>
            <form className="login-form" method="GET" action="/login">
                <input type="email" name="email" placeholder={t('login.emailPlaceholder', 'Email')} className="login-input"/>
                <input type="password" name="password" placeholder={t('login.password')} className="login-input"/>
                <button type="submit" className="login-button">
                    {t('login.loginButton')}
                </button>
                <p className="login-message">
                    {t('login.notRegistered')}{' '}
                    <Link to="/register">{t('login.createAnAccount')}</Link>
                </p>
            </form>
        </div>
    )
}