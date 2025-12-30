import React, { useState } from "react";
import { Tabs, Tab, Box, Typography } from "@mui/material";
import PendingPolicies from "./PendingPolicies";
import ActivePolicies from "./ActivePolicies";


export default function AdminUserPolicies() {
  const [activeTab, setActiveTab] = useState(0);

  return (
    <div style={{ display: "flex", flexDirection: "column", minHeight: "100vh" }}>
      <div style={{ flex: 1, padding: "20px", background: "#f4f6f8" }}>
        <Typography variant="h5" gutterBottom>
          🛡️ Manage User Policies
        </Typography>

        <Tabs
          value={activeTab}
          onChange={(e, newValue) => setActiveTab(newValue)}
          textColor="primary"
          indicatorColor="primary"
          sx={{ mb: 3 }}
        >
          <Tab label="📩 Pending Policies" />
          <Tab label="✅ Active Policies" />
        </Tabs>

        <Box sx={{ background: "#fff", borderRadius: "8px", p: 3, minHeight: "400px" }}>
          {activeTab === 0 && <PendingPolicies />}
          {activeTab === 1 && <ActivePolicies />}
          
        </Box>
      </div>
    </div>
  );
}
