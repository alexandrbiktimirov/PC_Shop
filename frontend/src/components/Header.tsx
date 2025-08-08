import React from 'react';
import {Navigation} from './Navigation';
import {useTranslation} from 'react-i18next';
import {NavLink} from "react-router-dom";

interface HeaderProps {
    loggedIn: boolean;
    fullName?: string | null;
    role?: 'CUSTOMER' | 'ADMIN';
}

export const Header: React.FC<HeaderProps> = ({loggedIn, fullName, role}) => (
    <header className="header">
        <Navigation />

        <div>
            {!loggedIn && <GuestMenu />}
            {loggedIn && role === 'CUSTOMER' && <CustomerMenu fullName={fullName!} />}
            {loggedIn && role === 'ADMIN' && <AdminMenu fullName={fullName!} />}
        </div>
    </header>
);

const GuestMenu: React.FC = () => {
    const {t} = useTranslation();
    return (
        <ul className="header-menu">
            <li><NavLink to="/register" className="header-link">{t('header.signup')}</NavLink></li>
            <li><NavLink to="/login" className="header-link">{t('header.login')}</NavLink></li>
        </ul>
    );
};

const CustomerMenu: React.FC<{ fullName: string }> = ({ fullName }) => {
    const {t} = useTranslation();
    return (
        <div className="relative inline-block">
            <button className="header-btn">{fullName}</button>
            <ul className="menu-list">
                <li><a href="/orders" className="menu-item">{t('header.myOrders')}</a></li>
                <li><a href="/builds" className="menu-item">{t('header.myBuilds')}</a></li>
                <li><a href="/profile" className="menu-item">{t('header.profile')}</a></li>
            </ul>
        </div>
    );
};

const AdminMenu: React.FC<{ fullName: string }> = ({ fullName }) => {
    const {t} = useTranslation();
    return (
        <div className="relative inline-block">
            <button className="header-btn">{fullName}</button>
            <ul className="menu-list">
                <li><a href="/dashboard" className="menu-item">{t('header.dashboard')}</a></li>
                <li><a href="/profile" className="menu-item">{t('header.profile')}</a></li>
            </ul>
        </div>
    );
};