import {useTranslation} from "react-i18next";
import React from "react";
import {Search} from 'lucide-react';
import {LanguageSwitcher} from "./LanguageSwitcher.tsx";
import {ThemeSwitcher} from "./ThemeSwitcher.tsx";

export const Navigation: React.FC = () => {
    const {t} = useTranslation();
    const components = [t('components.cpu'),
                                t('components.gpu'),
                                t('components.ram'),
                                t('components.psu'),
                                t('components.motherboard'),
                                t('components.case'),
                                t('components.storage'),
                                t('components.cooling'),
    ];

    return (
        <nav className="flex items-center space-x-6">
            <div className="group relative inline-block">
                <button className="px-2 py-1 hover:bg-gray-200 rounded">{t('header.components')}</button>
                <ul className="hidden group-hover:block absolute left-0 mt-2 w-40 bg-white border rounded shadow-lg z-10">
                    {components.map((component) => (
                        <li key={component}><a href={`/components/${component.toLowerCase()}`} className="block px-4 py-2 hover:bg-gray-100">{component}</a></li>
                    ))}
                </ul>
            </div>

            <a href="/forum" className="hover:underline">{t('header.forum')}</a>

            <form onSubmit={(e) => {
                e.preventDefault();
                const query = (e.currentTarget.elements.namedItem('query') as HTMLInputElement).value.trim();
                if (query) window.location.href = `/search?query=${encodeURIComponent(query)}`;
            }} className="relative flex items-center">
                <input name="query" type="text" className="w-full border rounded pl-2 pr-10 py-1 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400" placeholder={t('header.searchPlaceholder')} />
                <button type="submit" className="absolute right-1 top-1/2 -translate-y-1/2 p-1 rounded hover:bg-gray-200 dark:hover:bg-gray-700"><Search size={16} className="text-gray-500 dark:text-gray-300"/></button>
            </form>

            <ThemeSwitcher />
            <LanguageSwitcher />
        </nav>
    )
}