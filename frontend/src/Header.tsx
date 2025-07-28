import React from 'react';
import {Navigation} from './Navigation';
import { useTranslation } from 'react-i18next';

interface HeaderProps{
    loggedIn: boolean;
    fullName?: string | null;
    role?: "CUSTOMER" | "ADMIN";
}

export const Header: React.FC<HeaderProps> = ({loggedIn, fullName, role}) => {
    return (
        <header className="flex items-center justify-between p-4 bg-gray-100">
            <div className="flex items-center space-x-6">
                <a href="/"><img src="/assets/logo.png" alt="Logo" className="h-6 w-6" /></a>
                <Navigation />
            </div>

            <div>
                {!loggedIn && <GuestMenu/>}
                {loggedIn && role === "CUSTOMER" && <CustomerMenu fullName={fullName!}/>}
                {loggedIn && role === "ADMIN" && <AdminMenu fullName={fullName!}/>}
            </div>
        </header>
    )
}

const GuestMenu: React.FC = () => {
    const { t } = useTranslation()
    return(
        <ul className="flex space-x-4">
            <li><a href="/signup">{(t('header.signup'))}</a></li>
            <li><a href="/login">{(t('header.login'))}</a></li>
        </ul>
    )
}

const CustomerMenu: React.FC<{fullName : string}> = ({fullName}) => {
    const { t } = useTranslation()
    return (
        <div className="relative inline-block">
            <button className="px-4 py-2 hover:bg-gra-200 rounded">{fullName}</button>
            <ul className="absolute right-0 mt-2 w-48 bg-white border rounded shadow-lg z-10">
                <li><a className="block px-4 py-2 hover:bg-gray-100" href="/orders">{t('header.myOrders')}</a></li>
                <li><a className="block px-4 py-2 hover:bg-gray-100" href="/builds">{t('header.myBuilds')}</a></li>
                <li><a className="block px-4 py-2 hover:bg-gray-100" href="/profile">{t('header.profile')}</a></li>
            </ul>
        </div>
    )
}

const AdminMenu: React.FC<{fullName : string}> = ({fullName}) => {
    const { t } = useTranslation()
    return (
        <div className="relative inline-block">
            <button className="px-4 py-2 hover:bg-gray-200 rounded">{fullName}</button>
            <ul className="absolute right-0 mt-2 w-48 bg-white border rounded shadow-lg z-10">
                <li><a className="block px-4 py-2 hover:bg-gray-100" href="/dashboard">{t('header.dashboard')}</a></li>
                <li><a className="block px-4 py-2 hover:bg-gray-100" href="/profile">{t('header.profile')}</a></li>
            </ul>
        </div>
    )
}