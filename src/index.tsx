import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-deviceinfo1' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const Deviceinfo1 = NativeModules.Deviceinfo1
  ? NativeModules.Deviceinfo1
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return Deviceinfo1.multiply(a, b);
}

export function devicename(): Promise<number> {
  return Deviceinfo1.devicename();
}
