import readlineSync from 'readline-sync';
import startEvenGame from './games/even';
import startCalcGame from './games/calc';
import startGcdGame from './games/gcd';
import startProgressionGame from './games/progression';
import startBalanceGame from './games/balance';
import startPrimeGame from './games/prime';

const menuList = ['brain-even', 'brain-calc', 'brain-gcd', 'brain-progression', 'brain-balance', 'brain-prime'];

const index = readlineSync.keyInSelect(menuList, 'Choose game:');

const startChoosenGame = (game) => {
  switch (menuList[game]) {
    case 'brain-even':
      startEvenGame();
      break;
    case 'brain-calc':
      startCalcGame();
      break;
    case 'brain-gcd':
      startGcdGame();
      break;
    case 'brain-progression':
      startProgressionGame();
      break;
    case 'brain-balance':
      startBalanceGame();
      break;
    case 'brain-prime':
      startPrimeGame();
      break;
    default:
      console.log('\nSee ya!');
  }
};

const initializeMenu = () => startChoosenGame(index);

export default initializeMenu;
