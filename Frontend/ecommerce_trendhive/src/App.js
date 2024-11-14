import './App.css';
import Navbar from './components/Navbar/Navbar';
import Footer from './components/BottomFooter/Footer';
import { Checkout } from './components/CheckOut/CheckOut';
import { SignUp } from './components/SignUp/SignUp';
import { SignIn } from './components/SignIn/SignIn';
import { ContactUs } from './components/Contact/ContactUs';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { routes } from './components/SiteManager';
import HomePage from './components/Home/HomePage';
import ProductPage from './components/Product/ProductPage';

function App() {
  return (
    <Router>
      <Navbar />

      <Routes>
        <Route path={routes.home} element={<HomePage />} />
        <Route path={routes.product} element={<ProductPage />} />
        <Route path={routes.checkout} element={<Checkout />} />
        <Route path={routes.contactUs} element={<ContactUs />} />
        <Route path={routes.signUp} element={<SignUp />} />
        <Route path={routes.signIn} element={<SignIn />} />
      </Routes>

      <Footer />
    </Router>
  );
}

export default App;
