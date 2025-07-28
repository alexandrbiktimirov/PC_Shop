import './App.css'
import {Header} from './Header'
import {Slider} from "./Slider.tsx";
import {Components} from "./Components.tsx";
import {Footer} from "./Footer.tsx";

function App() {
  return (
      <>
          <Header loggedIn={false} />
          <div className="h-[calc(100vh-4rem)] overflow-hidden">
              <Slider />
          </div>
          <Components />
          <Footer />
      </>
  )
}

export default App
