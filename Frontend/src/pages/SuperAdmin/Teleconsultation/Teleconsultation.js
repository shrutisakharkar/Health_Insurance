import React, { useState } from "react";
import SuperAdminSidebar from "../SuperAdminSidebar";
import SuperAdminNavbar from "../SuperAdminNavbar";

import IndependentDoctorList from "./IndependentDoctorList";
import HospitalList from "./HospitalList";
import DoctorList from "./DoctorList";

export default function Teleconsultation() {
  const [activeTab, setActiveTab] = useState("hospital");

  const tabStyle = {
    padding: "10px 20px",
    cursor: "pointer",
    borderBottom: "3px solid transparent",
    fontWeight: "600",
  };

  const activeStyle = {
    ...tabStyle,
    borderBottom: "3px solid #1e40af",
    color: "#1e40af",
  };

  return (
    <div style={{ display: "flex", minHeight: "100vh" }}>
      <SuperAdminSidebar />

      <div style={{ flex: 1, display: "flex", flexDirection: "column" }}>
        <SuperAdminNavbar />

        <div style={{ padding: "20px" }}>
          <h2 style={{ marginBottom: "15px", fontWeight: "bold" }}>
            🩺 Teleconsultation
          </h2>

          {/* ✅ Horizontal Tabs */}
          <div
            style={{
              display: "flex",
              gap: "20px",
              marginBottom: "20px",
              borderBottom: "1px solid #ddd",
              paddingBottom: "8px",
              flexWrap: "wrap",
            }}
          >
            <span
              style={activeTab === "hospital" ? activeStyle : tabStyle}
              onClick={() => setActiveTab("hospital")}
            >
              Hospital List
            </span>

            <span
              style={activeTab === "doctor" ? activeStyle : tabStyle}
              onClick={() => setActiveTab("doctor")}
            >
              Doctor List
            </span>

            <span
              style={activeTab === "independent" ? activeStyle : tabStyle}
              onClick={() => setActiveTab("independent")}
            >
              Independent Doctor List
            </span>
          </div>

          {/* ✅ Screen Switching */}
          {activeTab === "hospital" && <HospitalList />}
          {activeTab === "doctor" && <DoctorList />}
          {activeTab === "independent" && <IndependentDoctorList />}
        </div>
      </div>
    </div>
  );
}
