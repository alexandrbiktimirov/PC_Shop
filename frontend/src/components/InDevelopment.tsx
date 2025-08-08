import React from "react";
import {useTranslation} from "react-i18next";

export const InDevelopment : React.FC = () => {
    const {t} = useTranslation();

    return (
        <div>
            <h1 className="info">{t('messages.inDevelopment')}</h1>
        </div>
    )
}