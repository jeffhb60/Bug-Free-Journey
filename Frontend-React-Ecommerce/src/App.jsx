import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {FaBeer} from "react-icons/fa";

function App() {
  const [count, setCount] = useState(0)

  return (
      <div className='flex items-center justify-center h-screen bg-gray-800 text-2xl font-bold text-white'>
          Welcome&nbsp; <FaBeer />

      </div>


  )
}

export default App
