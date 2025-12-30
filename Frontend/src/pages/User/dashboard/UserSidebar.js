import { Link } from 'react-router-dom';
import './UserSidebar.css';
import logo from '../../../assets/logo.png';

export default function UserSidebar() {
  return (
    <div className="user-sidebar">
      <div className="logo-section">
        {/* Clickable Logo Redirects to Home */}
        <Link to="/" className="logo-link">
          <img src={logo} alt="Logo" className="logo" />
        </Link>
      </div>

      <ul>
        <li><Link to="/dashboard/profile">My Profile</Link></li>
        <li><Link to="/dashboard/appointments">My Appointments</Link></li>
        <li><Link to="/dashboard/policies">My Policies</Link></li>
        <li><Link to="/dashboard/documents">My Documents</Link></li>
        {/* <li><Link to="/dashboard/claims">My Claims</Link></li> */}
      </ul>
    </div>
  );
}
