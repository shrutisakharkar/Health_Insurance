import React from "react";
import { NavLink } from "react-router-dom";
import logo from '../../assets/logo.png';
import { LayoutDashboard, Users, FileText, Stethoscope, ShieldCheck } from "lucide-react";

export default function SuperAdminSidebar() {
  const menuItems = [
    { name: "Dashboard", path: "/superadmin/dashboard", icon: <LayoutDashboard size={18} /> },
    { name: "Users", path: "/superadmin/dashboard/users", icon: <Users size={18} /> },
    { name: "Teleconsultation", path: "/superadmin/dashboard/teleconsultation", icon: <Stethoscope size={18} /> },
    { name: "Policies", path: "/superadmin/dashboard/policies", icon: <FileText size={18} /> },
    // { name: "Claims", path: "/superadmin/dashboard/claims", icon: <FileText size={18} /> },
    { name: "Admins", path: "/superadmin/dashboard/admins", icon: <ShieldCheck size={18} /> },
    { name: "FAQs", path: "/superadmin/dashboard/faqs", icon: <FileText size={18} /> },
  ];

  return (
    <div style={styles.sidebar}>
      <div className="logo-section" style={{ textAlign: "center", marginBottom: "40px" }}>
        <img src={logo} alt="QST Health Insurance" style={{ width: "160px", objectFit: "contain" }} />
      </div>
      
      <nav style={styles.nav}>
        {menuItems.map((item, index) => (
          <NavLink
            key={index}
            to={item.path}
            style={({ isActive }) => ({
              ...styles.link,
              backgroundColor: isActive ? "#2563eb" : "transparent",
              color: isActive ? "#fff" : "#333",
            })}
          >
            <span style={styles.icon}>{item.icon}</span>
            {item.name}
          </NavLink>
        ))}
      </nav>
    </div>
  );
}

const styles = {
  sidebar: {
    width: "240px",
    backgroundColor: "#fff",
    borderRight: "1px solid #ddd",
    padding: "25px 15px",
    display: "flex",
    flexDirection: "column",
    minHeight: "100vh",
  },
  nav: {
    display: "flex",
    flexDirection: "column",
    gap: "12px",
  },
  link: {
    display: "flex",
    alignItems: "center",
    padding: "10px 15px",
    borderRadius: "8px",
    textDecoration: "none",
    fontSize: "15px",
    transition: "0.3s",
    color: "#333",
  },
  icon: {
    marginRight: "10px",
    display: "flex",
    alignItems: "center",
  },
};
