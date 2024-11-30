import React, { useState } from "react";

export const AddUser = () => {
  const returnToHome = () => {};

  //Hookes
  const [username, setUsername] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  return (
    <div className="container ">
      <div className="font-bold text-xl content-center flex justify-center text-blue-500 bg-cyan-300 p-6">
        REGISTER HERE!!!
      </div>
      <div className="form flex justify-center p-4 ">
        <div>
          <label htmlFor="" className="p-2 mx-3 ">
            Name
          </label>
          <input
            type="text"
            placeholder="Name"
            name="name"
            className="p-1 bg-cyan-100 border border-cyan-400 rounded-md mx-4 w-80"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
      </div>
      <div className="form flex justify-center p-4">
        <div>
          <label htmlFor="" className="p-2 mx-3">
            Username
          </label>
          <input
            type="text"
            placeholder="username"
            name="username"
            className="p-1 bg-cyan-100 border border-cyan-400 rounded-md mx-4 w-80"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>
      </div>
      <div className="form flex justify-center p-4">
        <div>
          <label htmlFor="" className="p-2 mx-3">
            E-mail
          </label>
          <input
            type="text"
            placeholder="E-mail"
            name="mail"
            className="p-1 bg-cyan-100 border border-cyan-400 rounded-md mx-4 w-80"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
      </div>
      <div className="form flex justify-center p-4">
        <button
          type="submit"
          className="bg-green-500  rounded-lg border border-white  flex justify-center mx-5 p-2 hover:bg-blue-400"
        >
          Submit
        </button>

        <button
          type="submit"
          className="bg-green-500  rounded-lg border border-white  flex justify-center mx-5 p-2 hover:bg-red-400"
        >
          Cancel
        </button>
      </div>
    </div>
  );
};
