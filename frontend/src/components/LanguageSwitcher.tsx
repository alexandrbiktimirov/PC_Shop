import React from 'react';
import {useTranslation} from 'react-i18next';

export const LanguageSwitcher: React.FC = () => {
    const { i18n } = useTranslation();
    return (
        <select value={i18n.language}
                onChange={(e) => i18n.changeLanguage(e.target.value)}
                className="language-switcher">
            <option value="en">🇺🇸English</option>
            <option value="pl">🇵🇱Polski</option>
        </select>
    );
};