import { useState } from 'react'
import './App.css'
import { Prueba } from  './components'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <Prueba/>
    </div>
  )
}

export default App
