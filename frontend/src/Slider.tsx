import {useTranslation} from "react-i18next";
import React, { useEffect, useState } from 'react';

interface Slide {
    title: string;
    description: string;
    imageUrl: string;
}

export const Slider: React.FC = () => {
    const {t} = useTranslation();

    const slides: Slide[] = [
        {
            title: t('slider.compatibility.title'),
            description: t('slider.compatibility.description'),
            imageUrl: "/assets/slides/compatibility.png",
        },
        {
            title: t('slider.forum.title'),
            description: t('slider.forum.description'),
            imageUrl: "/assets/slides/forum.png",
        },
    ];

    const [current, setCurrent] = useState(0);

    useEffect(() => {
        const interval = setInterval(
            () => setCurrent((prev) => (prev + 1) % slides.length),
            5000
        );
        return () => clearInterval(interval);
    }, []);

    return (
        <div className="relative w-full h-full overflow-hidden">
            {slides.map((slide, index) => (
                <div
                    key={index}
                    className={`
            absolute inset-0 transition-opacity duration-700 ease-in-out
            ${index === current ? 'opacity-100 pointer-events-auto' : 'opacity-0 pointer-events-none'}
          `}
                >
                    <div className="absolute inset-0 z-0">
                        <img
                            src={slide.imageUrl}
                            alt={slide.title}
                            className="w-full h-full object-contain"
                        />
                    </div>

                    <div className="absolute inset-0 z-10 bg-black/50 pointer-events-none" />

                    <div className="absolute inset-0 z-20 flex flex-col items-center justify-center text-center px-4">
                        <h2 className="text-4xl font-bold text-white mb-2">
                            {slide.title}
                        </h2>
                        <p className="text-lg text-gray-200 max-w-xl">
                            {slide.description}
                        </p>
                    </div>
                </div>
            ))}

            <div className="absolute bottom-4 left-1/2 transform -translate-x-1/2 flex space-x-2 z-30">
                {slides.map((_, idx) => (
                    <button
                        key={idx}
                        onClick={() => setCurrent(idx)}
                        className={`
              w-3 h-3 rounded-full focus:outline-none
              ${idx === current ? 'bg-white' : 'bg-gray-400'}
            `}
                    />
                ))}
            </div>
        </div>
    );
};