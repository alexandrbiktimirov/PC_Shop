import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'
import tailwindcss from '@tailwindcss/vite'
import { fileURLToPath, URL} from 'url';

// https://vite.dev/config/
export default defineConfig({
  plugins: [react(), tailwindcss()],
  resolve: {
    alias: {
      '@locales': fileURLToPath(new URL('./public/locales', import.meta.url)),
    }
  },
  define: {
    __LOCALES_PATH__: JSON.stringify('/locales')
  }
})
