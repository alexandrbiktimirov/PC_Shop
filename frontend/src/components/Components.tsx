import React from 'react';
import {Link} from 'react-router-dom';
import {useTranslation} from 'react-i18next';

const components = [
    'CPU', 'GPU', 'RAM', 'Motherboard',
    'Case', 'Storage', 'Cooling', 'PSU',
];

export const Components: React.FC = () => {
    const {t} = useTranslation();

    return (
        <div className="flex justify-center mt-8">
            <div className="grid grid-cols-4 grid-rows-2 gap-6">
                {components.map((key) => {
                    const lookupKey = key.toLowerCase();

                    return (
                        <Link key={key} to={`/components/${lookupKey}s`} className="block">
                            <div className="component-card">
                                <span className="component-label">{t(`components.${lookupKey}`)}</span>
                            </div>
                        </Link>
                    );
                })}
            </div>
        </div>
    );
};