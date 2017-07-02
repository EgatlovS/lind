export class NavbarLink
{
   params: { rel: string, type: string };
   href: string;

   constructor(params: { rel: string, type: string }, href: string)
   {
      this.params = params;
      this.href = href;
   }
}
