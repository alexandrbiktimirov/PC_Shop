import './App.css'
import {Header} from './Header'
import {Slider} from "./Slider.tsx";
import {Components} from "./Components.tsx";

function App() {
  return (
      <>
          <Header loggedIn={false} />

          <div className="h-[calc(100vh-4rem)] overflow-hidden">
              <Slider />
          </div>

          <Components />
      </>
  )
}

export default App
