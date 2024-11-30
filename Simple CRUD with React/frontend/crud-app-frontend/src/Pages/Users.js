import React, { useEffect, useState } from "react";
import UserDetails from "./UserDetails";
import axios from "axios";

const Users = () => {
  //   const users = [
  //     { name: "user1", username: "user1", email: "f_user@gmail.com" },
  //     { name: "user2", username: "us2", email: "sf_user@gmail.com" },
  //     { name: "user3", username: "ser", email: "third@gmail.com" },
  //   ];

  const [users, setUsers] = useState([
    {
      name: "as",
      username: "",
      email: "",
    },
  ]);
  useEffect(() => {
    getUsers();
  }, []);

  var getUsers = async () => {
    var temp = await axios.get("http://localhost:8080/users");
    console.log(temp.data);
    setUsers(temp.data);
  };
  return (
    <div>
      <div className="table w-full ...">
        <div className="table-header-group ...">
          <div className="table-row">
            <div className="table-cell text-left ...">UserName</div>
            <div className="table-cell text-left ...">Name</div>
            <div className="table-cell text-left ...">Email</div>
            <div className="table-cell text-left font-bold ...">Action</div>
          </div>
        </div>
        <div className="table-row-group ">
          {users.map((user) => {
            return (
              <UserDetails
                key={user.id}
                name={user.name}
                username={user.username}
                email={user.email}
              />
            );
          })}
        </div>
      </div>
    </div>
  );
};

export default Users;
