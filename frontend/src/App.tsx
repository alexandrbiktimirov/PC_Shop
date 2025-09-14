import './App.css'
import {createBrowserRouter, createRoutesFromElements, Route, RouterProvider} from "react-router-dom";
import {RootLayout} from "./layout/RootLayout.tsx";
import {Home} from "./pages/Home.tsx";
import {Login} from "./pages/Login.tsx";
import {Register} from "./pages/Register.tsx";
import {NotFound} from "./pages/NotFound.tsx";
import {ComponentsPage} from "./pages/ComponentsPage.tsx";

function App() {

    const router = createBrowserRouter(
        createRoutesFromElements(
            <Route path='/' element={<RootLayout/>}>
                <Route index element={<Home/>}/>
                <Route path='login' element={<Login/>}/>
                <Route path='register' element={<Register/>}/>
                <Route path='components/:type' element={<ComponentsPage/>}/>
                <Route path='*' element={<NotFound/>}/>
            </Route>
        )
    )

    return (
      <div>
        <RouterProvider router={router}/>
      </div>
    )
}

export default App
