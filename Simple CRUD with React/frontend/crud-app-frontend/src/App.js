import Navbar from "./layout/Navbar";
import "./App.css";
import Home from "./Pages/Home";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { AddUser } from "./Components/AddUser";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        {/* <Home /> */}
        <Routes>
          <Route path="/" element={<Home></Home>} />
          <Route path="/addUser" element={<AddUser />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
