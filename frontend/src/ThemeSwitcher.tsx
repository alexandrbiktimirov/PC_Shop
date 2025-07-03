import React, {useEffect, useState} from "react";
import {Sun, Moon} from 'lucide-react';

export const ThemeSwitcher: React.FC = () => {
    const [dark, setDark] = useState(() => localStorage.theme === 'dark' || window.matchMedia('(prefers-color-scheme: dark)').matches);

    useEffect(() => {
        const root = document.documentElement;
        if (dark) {
            root.classList.add('dark');
            localStorage.theme = 'dark';
        } else{
            root.classList.remove('dark');
            localStorage.theme = 'light';
        }
    }, [dark]);

    return (
        <button onClick={() => setDark(prev => !prev)} className="p-1 rounded hover:bg-gray-200 dark:hover:bg-gray-700">
            {dark ? <Sun /> : <Moon />}
        </button>
    )
}