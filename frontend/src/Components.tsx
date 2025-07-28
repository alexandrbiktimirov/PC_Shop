import React from 'react';
import { Link } from 'react-router-dom';
import { useTranslation } from 'react-i18next';

const components = [
    'CPU',
    'GPU',
    'RAM',
    'Motherboard',
    'Case',
    'Storage',
    'Cooling',
    'PSU',
];

export const Components: React.FC = () => {
    const { t } = useTranslation();

    return (
        <div className="flex justify-center mt-8">
            <div className="grid grid-cols-4 grid-rows-2 gap-6">
                {components.map((key) => {
                    const lookupKey = key.toLowerCase();

                    return (
                        <Link key={key} to={`/components/${lookupKey}`} className="block">
                            <div
                                className="
                                  w-26 h-26
                                  bg-gray-800 rounded-lg
                                  flex items-center justify-center
                                  border border-transparent
                                  transform transition
                                  duration-200 ease-in-out
                                  hover:scale-105 hover:shadow-lg hover:border-blue-500">
                                <span className="text-sm font-medium text-white text-center break-words">
                                  {t(`components.${lookupKey}`)}
                                </span>
                            </div>
                        </Link>
                    );
                })}
            </div>
        </div>
    );
};