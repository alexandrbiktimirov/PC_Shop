import React, {useEffect, useRef, useState} from 'react';
import {NavLink } from 'react-router-dom';
import {useTranslation } from 'react-i18next';
import {Search} from 'lucide-react';
import {ThemeSwitcher} from './ThemeSwitcher';
import {LanguageSwitcher} from './LanguageSwitcher';

export const Navigation: React.FC = () => {
    const {t} = useTranslation();
    const componentKeys = ['cpu','gpu','ram','psu','motherboard','case','storage','cooling'];

    const [open, setOpen] = useState(false);
    const containerRef = useRef<HTMLDivElement>(null);

    useEffect(() => {
        const handleClick = (e: MouseEvent) => {
            if (containerRef.current && !containerRef.current.contains(e.target as Node)) {
                setOpen(false);
            }
        };
        document.addEventListener('mousedown', handleClick);
        return () => document.removeEventListener('mousedown', handleClick);
    }, []);

    return (
        <nav className="navigation">
            <NavLink to="/">
                <img src="/assets/logo.png" alt="Logo" className="h-10 w-10" />
            </NavLink>

            <div className="dropdown" ref={containerRef}>
                <button onClick={() => setOpen((o) => !o)} className="dropdown-btn">{t('header.components')}</button>
                <ul className={`dropdown-menu ${open ? 'show' : ''}`}>
                    {componentKeys.map((key) => (
                        <li key={key}>
                            <NavLink to={`/components/${key}`} className="dropdown-item">{t(`components.${key}`)}</NavLink>
                        </li>
                    ))}
                </ul>
            </div>

            <form onSubmit={(e) => {
                    e.preventDefault();
                    const q = (e.currentTarget.elements.namedItem('query') as HTMLInputElement).value.trim();
                    if (q) window.location.href = `/search?query=${encodeURIComponent(q)}`;
                }}
                className="search-form">
                <input name="query" type="text" className="search-input" placeholder={t('header.searchPlaceholder')}/>
                <button type="submit" className="search-button"><Search size={16} /></button>
            </form>

            <ThemeSwitcher />
            <LanguageSwitcher />
        </nav>
    );
};