import { cons } from 'hexlet-pairs';
import { makeGame } from '..';
import generateNumber from '../utils';

const rule = 'What number is missing in this progression?';

const valueRangeMin = 1;
const valueRangeMax = 100;
const progressionLength = 10;

const makeProgression = (first, difference, length, skippedPosition) => {
  const iter = (counter, progression, skippedNumber) => {
    if (counter > length) {
      return cons(progression, skippedNumber);
    }

    if (counter === skippedPosition) {
      return iter(counter + 1, `${progression}.. `, `${first + ((counter - 1) * difference)}`);
    }

    return iter(counter + 1, `${progression + (first + ((counter - 1) * difference))} `, skippedNumber);
  };

  return iter(1, '', 0);
};

const askProgression = () => {
  const firstElement = generateNumber(valueRangeMin, valueRangeMax);
  const step = generateNumber(valueRangeMin, valueRangeMax);
  const skippedElement = generateNumber(1, progressionLength);
  const game = makeProgression(firstElement, step, progressionLength, skippedElement);
  return game;
};

const startProgressionGame = () => makeGame(askProgression, rule);

export default startProgressionGame;
