import React from "react";
import {useTranslation} from "react-i18next";

export const NotFound: React.FC = () => {
    const {t} = useTranslation();

    return (
        <div>
            <h1 className="info">{t('messages.notFound')}</h1>
        </div>
    )
}