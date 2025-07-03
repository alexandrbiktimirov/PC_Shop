import React from 'react';
import {useTranslation} from 'react-i18next';

export const LanguageSwitcher: React.FC = () => {
    const {i18n} = useTranslation();

    return (
        <select value={i18n.language}
                onChange={(e) => i18n.changeLanguage(e.target.value)}
                className="border p-1 rounded dark:bg-gray-700 dark:border-gray-600"
        >
            <option value="en">English</option>
            <option value="pl">Polish</option>
        </select>
    )
}