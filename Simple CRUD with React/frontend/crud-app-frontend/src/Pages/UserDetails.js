import { Button } from "@headlessui/react";
import React from "react";

const UserDetails = ({ username, name, email }) => {
  const deleteUser = () => {};
  return (
    <div className="table-row ">
      <div className="table-cell ...">{username}</div>
      <div className="table-cell ...">{name}</div>
      <div className="table-cell ...">{email}</div>
      <Button
        className="bg-violet-700 rounded-lg border-black border m-1 p-1 text-white hover:bg-red-500 px-2"
        onClick={() => deleteUser}
      >
        DELETE
      </Button>
    </div>
  );
};

export default UserDetails;
