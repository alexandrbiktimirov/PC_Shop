import './App.css'
import {Header} from './Header'
import {Slider} from "./Slider.tsx";

function App() {
  return (
      <div className="flex flex-col h-screen">
          <Header loggedIn={false} />
          <main className="flex-1">
              <Slider />
          </main>
      </div>
  )
}

export default App
