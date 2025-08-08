import React from "react";
import {Header} from "../components/Header.tsx";
import {Footer} from "../components/Footer.tsx";
import {Outlet} from "react-router-dom";

export const RootLayout : React.FC = () => {
    return (
        <div className="page-wrapper">
            <Header loggedIn={false} />
            <div className="page-content">
                <Outlet />
            </div>
            <Footer />
        </div>
    )
}