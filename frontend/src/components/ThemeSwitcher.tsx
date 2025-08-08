import React, {useEffect, useState} from 'react';
import {Sun, Moon} from 'lucide-react';

export const ThemeSwitcher: React.FC = () => {
    const [dark, setDark] = useState(() => localStorage.theme === 'dark' || window.matchMedia('(prefers-color-scheme: dark)').matches);

    useEffect(() => {
        const root = document.documentElement;
        if (dark) {
            root.classList.add('dark');
            localStorage.theme = 'dark';
        } else {
            root.classList.remove('dark');
            localStorage.theme = 'light';
        }
    }, [dark]);

    return (
        <button onClick={() => setDark((d) => !d)} className="theme-switcher-btn">
            {dark ? <Moon /> : <Sun />}
        </button>
    );
};