import React, {useEffect, useState} from 'react';
import {useTranslation} from 'react-i18next';

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
            imageUrl: '/assets/slides/compatibility.png',
        },
        {
            title: t('slider.forum.title'),
            description: t('slider.forum.description'),
            imageUrl: '/assets/slides/forum.png',
        },
    ];

    const [current, setCurrent] = useState(0);

    useEffect(() => {
        const iv = setInterval(() => setCurrent((i) => (i + 1) % slides.length), 5000);
        return () => clearInterval(iv);
    }, [slides.length]);

    return (
        <div className="slider">
            {slides.map((slide, i) => (
                <div key={i} className={`slide-item ${i === current ? 'slide-item-active' : ''}`}>
                    <img src={slide.imageUrl} alt={slide.title} className="w-full h-full object-contain" />
                    <div className="slide-overlay" />
                    <div className="slide-content">
                        <h2 className="slide-title">{slide.title}</h2>
                        <p className="slide-desc">{slide.description}</p>
                    </div>
                </div>
            ))}
            <div className="slider-dots">
                {slides.map((_, i) => (
                    <button key={i} onClick={() => setCurrent(i)} className={`slider-dot ${i === current ? 'slider-dot-active' : ''}`}/>
                ))}
            </div>
        </div>
    );
};