import React from "react";
import {Slider} from "../components/Slider.tsx";
import {Components} from "../components/Components.tsx";

export const Home : React.FC = () => {
    return (
        <div>
            <Slider />
            <Components />
        </div>
    )
}